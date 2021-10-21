package com.nwpu.eth.Test;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthSyncing;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.math.BigInteger;


/**
 * @Author: ch
 * @Description:
 * @Date: Created in 9:50 2021/10/20
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) throws  ExecutionException, InterruptedException {
        Web3j web3 = Web3j.build(new HttpService("http://10.69.177.223:8545"));

        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("我的版本:"+clientVersion);

        Admin web3j = Admin.build(new HttpService("http://10.69.177.223:8545"));  // defaults to http://localhost:8545/
        PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount("0x1b740d5ffd54da76b495c637a951eaed596393cb", "123").sendAsync().get();
        if (personalUnlockAccount.accountUnlocked()) {
            System.out.println("账户解锁");
        }

        try {
            //区块数量
            EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().send();
            BigInteger blockNumber = ethBlockNumber.getBlockNumber();
            System.out.println(blockNumber);
            //挖矿奖励账户
            EthCoinbase ethCoinbase = web3j.ethCoinbase().send();
            String coinbaseAddress = ethCoinbase.getAddress();
            System.out.println(coinbaseAddress);
            //是否在同步区块
            EthSyncing ethSyncing = web3j.ethSyncing().send();
            boolean isSyncing = ethSyncing.isSyncing();
            System.out.println(isSyncing);
            //是否在挖矿
            EthMining ethMining = web3j.ethMining().send();
            boolean isMining = ethMining.isMining();
            System.out.println(isMining);
            //当前gas price
            EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
            BigInteger gasPrice = ethGasPrice.getGasPrice();
            System.out.println(gasPrice);
            //挖矿速度
            EthHashrate ethHashrate = web3j.ethHashrate().send();
            BigInteger hashRate = ethHashrate.getHashrate();
            System.out.println(hashRate);
            //协议版本
            EthProtocolVersion ethProtocolVersion = web3j.ethProtocolVersion().send();
            String protocolVersion = ethProtocolVersion.getProtocolVersion();
            System.out.println(protocolVersion);
            //连接的节点数
            NetPeerCount netPeerCount = web3j.netPeerCount().send();
            BigInteger peerCount = netPeerCount.getQuantity();
            System.out.println(peerCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
