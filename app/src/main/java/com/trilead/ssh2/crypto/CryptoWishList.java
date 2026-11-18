package com.trilead.ssh2.crypto;

import com.trilead.ssh2.compression.CompressionFactory;
import com.trilead.ssh2.crypto.cipher.BlockCipherFactory;
import com.trilead.ssh2.crypto.digest.MACs;
import com.trilead.ssh2.transport.KexManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CryptoWishList {
    public String[] kexAlgorithms = KexManager.getDefaultKexAlgorithmList();
    public String[] serverHostKeyAlgorithms = KexManager.getDefaultServerHostkeyAlgorithmList();
    public String[] c2s_enc_algos = BlockCipherFactory.getDefaultCipherList();
    public String[] s2c_enc_algos = BlockCipherFactory.getDefaultCipherList();
    public String[] c2s_mac_algos = MACs.getMacList();
    public String[] s2c_mac_algos = MACs.getMacList();
    public String[] c2s_comp_algos = CompressionFactory.getDefaultCompressorList();
    public String[] s2c_comp_algos = CompressionFactory.getDefaultCompressorList();
}
