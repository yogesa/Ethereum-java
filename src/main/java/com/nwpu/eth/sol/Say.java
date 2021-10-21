package com.nwpu.eth.sol;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class Say extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506102fe806100206000396000f3006080604052600436106100565763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416634ed3885e811461005b578063954ab4b2146100b6578063a75f578614610140575b600080fd5b34801561006757600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100b49436949293602493928401919081908401838280828437509497506101559650505050505050565b005b3480156100c257600080fd5b506100cb61016c565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101055781810151838201526020016100ed565b50505050905090810190601f1680156101325780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561014c57600080fd5b506100cb610203565b805161016890600090602084019061023a565b5050565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156101f85780601f106101cd576101008083540402835291602001916101f8565b820191906000526020600020905b8154815290600101906020018083116101db57829003601f168201915b505050505090505b90565b60408051808201909152601081527f68656c6c6f20626c6f636b436861696e00000000000000000000000000000000602082015290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061027b57805160ff19168380011785556102a8565b828001600101855582156102a8579182015b828111156102a857825182559160200191906001019061028d565b506102b49291506102b8565b5090565b61020091905b808211156102b457600081556001016102be5600a165627a7a723058205ec4b74262c1e62c15b1394edb9c69fa6bf1d9f333e26e0654648519043c1bba0029";

    public static final String FUNC_SET = "set";

    public static final String FUNC_SAY = "say";

    public static final String FUNC_HELLOWORLD = "Helloworld";

    @Deprecated
    protected Say(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Say(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Say(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Say(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> set(String _msg) {
        final Function function = new Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_msg)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> say() {
        final Function function = new Function(FUNC_SAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> Helloworld() {
        final Function function = new Function(FUNC_HELLOWORLD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Say load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Say(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Say load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Say(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Say load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Say(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Say load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Say(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Say> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Say.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Say> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Say.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Say> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Say.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Say> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Say.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
