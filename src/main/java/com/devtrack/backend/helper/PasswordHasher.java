package com.devtrack.backend.helper;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.springframework.stereotype.Service;

/**
 * Hashes passwords with PBKDF2 and a unique random salt per password.
 *
 * <p>The stored format is {@code iterations:salt:hash}, so verification can
 * continue to work if the iteration count is increased in the future.
 */
@Service
public class PasswordHasher {
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 210_000;
    private static final int KEY_LENGTH = 256;
    private static final int SALT_LENGTH = 16;
    private final SecureRandom secureRandom = new SecureRandom();

    public String hash(String password) {
        byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        byte[] derivedKey = derive(password, salt, ITERATIONS);
        return ITERATIONS + ":" + encode(salt) + ":" + encode(derivedKey);
    }

    public boolean matches(String password, String storedHash) {
        try {
            String[] parts = storedHash.split(":", -1);
            if (parts.length != 3) {
                return false;
            }

            int iterations = Integer.parseInt(parts[0]);
            byte[] salt = Base64.getDecoder().decode(parts[1]);
            byte[] expected = Base64.getDecoder().decode(parts[2]);
            byte[] actual = derive(password, salt, iterations);
            return MessageDigest.isEqual(actual, expected);
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    private byte[] derive(String password, byte[] salt, int iterations) {
        if (iterations < 1) {
            throw new IllegalArgumentException("Password hash iterations must be positive");
        }
        try {
            PBEKeySpec specification = new PBEKeySpec(
                    password.toCharArray(), salt, iterations, KEY_LENGTH);
            return SecretKeyFactory.getInstance(ALGORITHM)
                    .generateSecret(specification)
                    .getEncoded();
        } catch (GeneralSecurityException exception) {
            throw new IllegalStateException("Password hashing is unavailable", exception);
        }
    }

    private String encode(byte[] value) {
        return Base64.getEncoder().encodeToString(value);
    }
}
