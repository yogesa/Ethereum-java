package com.nwpu.eth.sol;

import com.nwpu.eth.Environment.Environment;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import java.math.BigInteger;


/**
 * @Author: ch
 * @Description:
 * @Date: Created in 15:03 2021/10/20
 * @Modified By:
 */
public class SaySample {

    public static String contractAddress ;

    public static void main(String[] args) {
       deploy();
       use();
    }

    private static void deploy() {

        Web3j web3j = Web3j.build(new HttpService(Environment.RPC_URL));

        try {
        //source文件是以太坊结点中，运行geth客户端生成的文件，data/keystore/下面私钥文件，如果geth在服务器上运行，把它拷贝下来，放在运行IDEA的电脑的E盘中
        Credentials credentials = WalletUtils.loadCredentials("","E:/key/UTC--2021-10-20T12-59-22.361130133Z--1b95df7fa63ed235313016738c36c47e031e409e");

        RemoteCall<Say> deploy = Say.deploy(web3j, credentials,new StaticGasProvider(BigInteger.valueOf(3000000),BigInteger.valueOf(3000000)));

        Say say = deploy.send();
        contractAddress = say.getContractAddress();
        System.out.println(contractAddress);
        System.out.println("say.isValid():"+say.isValid());;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void use() {
        Web3j web3j = Web3j.build(new HttpService(Environment.RPC_URL));
        String contractAddress = SaySample.contractAddress;
        Credentials credentials = null;
        try {
            credentials = WalletUtils.loadCredentials("","E:/key/UTC--2021-10-20T12-59-22.361130133Z--1b95df7fa63ed235313016738c36c47e031e409e");
        Say contract = Say.load(contractAddress, web3j, credentials,
                new StaticGasProvider(BigInteger.valueOf(3000000),BigInteger.valueOf(3000000)));

            String returnvalue = contract.Helloworld().send();

            contract.set("chenhui").send();
            String sayvalue = contract.say().send();

            System.out.println(returnvalue + "-----" +sayvalue );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
