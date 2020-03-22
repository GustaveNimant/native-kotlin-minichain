# Minichain : A blockchain in kotlin using http4k (https://www.http4k.org/)
# Linux 
## sdkman (in order to install all the needed packages)
### installation of sdkman
    sudo apt install unzip
    sudo apt install zip
    (https://sdkman.io/install)
*  sdk uninstall _package_ x.y.z
*  sdk install _package_
*  sdk use gradle _package_ x.y.z
*  sdk flush archives

## gradle
### installation of gradle
*  sdk list gradle
*  sdk install gradle 6.1.1

### gradle init 

### build.gradle.kts
(https://github.com/GustaveNimant/native-kotlin-minichain/blob/master/build.gradle.kts)

### running gradle

#### settings.gradle.kts
     
     rootProject.name = 'native-kotlin-minichain'
     rootProject.buildFileName = "build.gradle.kts"

     gradlew build
     gradlew -q test
     gradlew test --info
     gradlew run --args="-debug all"
    
## No java 

## kotlin
### installation of kotlin

*  sdk install kotlin
  
## ipfs-api-kotlin (optional)

## native-kotlin-minichain

   git clone https://github.com/GustaveNimant/native-kotlin-minichain.git

## code structure

|-- native-kotlin-minichain
|--- src
      | main
        | kotlin
          | io
            | ipfs
              | kotlin
      | test
        | kotlin
          | io
            | ipfs
              | kotlin

### installation of kotlin-minichain

## Compiling
   cd ~/sources/native-kotlin-minichain
   
   gradlew build 

## Running tests
   cd ~/sources/native-kotlin-minichain
   
   gradlew test 

## License 

MIT
