1.首先利用geth搭建私有链 [https://blog.csdn.net/qq_38687287/article/details/77949634](https://blog.csdn.net/qq_38687287/article/details/77949634)

2.使用脚本打开geth  

```haskell
nohup geth --datadir data --networkid 666 --http --http.corsdomain="*" --http.port 8545 --http.addr "0.0.0.0" --http.api db,web3,eth,debug,personal,net,miner,admin --allow-insecure-unlock --rpc.allow-unprotected-txs  --port 30303  --dev --dev.period 1  2>./console.log &
```
3.使用Maven 将web3j加进来，可以参考[https://github.com/web3j/web3j-maven-plugin](https://github.com/web3j/web3j-maven-plugin)
```haskell
<build>
    <plugins>
        <plugin>
            <groupId>org.web3j</groupId>
            <artifactId>web3j-maven-plugin</artifactId>
            <version>4.8.7</version>
            <configuration>
                <soliditySourceFiles/>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.web3j</groupId>
            <artifactId>web3j-maven-plugin</artifactId>
            <version>4.8.7</version>
            <configuration>
                <packageName>com.zuehlke.blockchain.model</packageName>
                <sourceDestination>src/main/java/generated</sourceDestination>
                <nativeJavaType>true</nativeJavaType>
                <outputFormat>java,bin</outputFormat>
                <soliditySourceFiles>
                    <directory>src/main/resources</directory>
                    <includes>
                        <include>**/*.sol</include>
                    </includes>
                </soliditySourceFiles>
                <abiSourceFiles>
                    <directory>src/main/resources</directory>
                    <includes>
                        <include>**/*.json</include>
                    </includes>
                </abiSourceFiles>
                <outputDirectory>
                    <java>src/java/generated</java>
                    <bin>src/bin/generated</bin>
                    <abi>src/abi/generated</abi>
                </outputDirectory>
                <contract>
                    <includes>
                        <include>greeter</include>
                    </includes>
                    <excludes>
                        <exclude>mortal</exclude>
                    </excludes>
                </contract>
                <pathPrefixes>
                    <pathPrefix>dep=../dependencies</pathPrefix>
                </pathPrefixes>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <source>8</source>
                <target>8</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```
4. mvn web3j:generate-sources (运行前将sol文件放入resource中，可以先开始用简单的测试)

本项目与就是已经可以运行的小demo

打开SaySample，运行main（运行之前打开geth挖矿）

 打开SaySample，运行main（运行之前打开geth挖矿）

第一行是deploy()部署到区块链上的合约返回的地址

第二行表明回调函数返回的say合约对象可以使用

第三行表示调用区块链上获取的数据
结果图片：![$ZL_43M)}VE`9`DX PZYRLK](https://user-images.githubusercontent.com/30628588/138235905-497336ea-98c5-4bdd-aaee-28c0c138c8b4.png)


