import java.math.BigInteger;

class RSA {

    public static BigInteger encryptOrDecrypt(BigInteger m, BigInteger e, BigInteger n) {
        return m.modPow(e, n);
    }


    public static BigInteger generatePrivateKey(BigInteger e, BigInteger phi) {
        return e.modInverse(phi);
    }

    public static void main(String[] args) {

        BigInteger p = BigInteger.valueOf(61);
        BigInteger q = BigInteger.valueOf(53);
        
        // Calculate n = p * q
        BigInteger n = p.multiply(q);
        
        // Calculate phi = (p - 1) * (q - 1)
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        
        
        BigInteger e = BigInteger.valueOf(17);
        

        BigInteger d = generatePrivateKey(e, phi);
        
     
        BigInteger m = BigInteger.valueOf(65); 
        

        BigInteger c = encryptOrDecrypt(m, e, n);
        

        BigInteger decrypted = encryptOrDecrypt(c, d, n);
        

        System.out.println("Public Key (e, n) = (" + e + ", " + n + ")");
        System.out.println("Private Key (d) = " + d);
        System.out.println("Plaintext (m) = " + m);
        System.out.println("Encrypted message (c) = " + c);
        System.out.println("Decrypted message = " + decrypted);
    }
}
