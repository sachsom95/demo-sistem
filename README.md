#API
##Endpoints:
### Network Status
Gets general metadata about the current state of the blockchain network.
* GET
``` 
http://54.91.216.164:12035/chain/api/network/general-network-status 
```

* Response
```json
{
    "network": 1513115205,
    "version": "1.0.0.0",
    "witnesses": [
        "ZCXQkgv24jub4MJshWN2wGJbUVN7rdVvLD"
    ],
    "applications": [
        "APP2",
        "PTST"
    ],
    "genesis": {
        "slot": 0,
        "ref": "07a8d2932263922ce0939e9e7c7a9d91be426cc18dad20790a9ea3804841169c"
    },
    "current": {
        "slot": 38166,
        "ref": "c40efc2f3234bee9ea9f5ff041bf58fa72fc80b93b66836a77994d4496a892d0"
    },
    "alerts": []
}
```

### Blocks
This call returns the last confirmed block, or a range of blocks.

To get a range of blocks, use the `offset` and `count` parameters. Specifying
only the `offset` parameter will get a range of blocks up to the current slot,
or up to the maximum count.

Note that the maximum value for 'count' is 600.

For each returned item, the data will contain header information from
the block binary, and references to the block entries via the merkle roots.
* GET
``` 
http://54.91.216.164:12035/chain/api/network/blocks/?offset={{offset}}&count={{count}}
```

* Response
```json
[
    {
        "hash": "a811dcfd3d975e1357474de4b04a1c93eedae15d9f548ab67038caa977858cf1",
        "slot": 10,
        "version": "0.0.0.1",
        "previousBlock": "12996a768801d48d408b7b25b48bc61440f4e0e4e07f71e1c980694201e9775d",
        "partitions": [],
        "nonce": "8327154815783832656",
        "authority": "ZYz9bhvfPUbuQZoWEMPFuS5q5Cgkv91a6f",
        "signature": "3045022100b7f3924f48526c7b83cc5be8d8610445ee6356e4f474e1426f35cd51923e39a40220312fcb0536bc60f37c73c01042cfb541350b84cbb8dc3d3aed26a9d478a6afb1"
    },
    {
        "hash": "43d527cd46f0bddc40c1c254cd1c29f400eec38c1c282bcd976d26affe925488",
        "slot": 11,
        "version": "0.0.0.1",
        "previousBlock": "a811dcfd3d975e1357474de4b04a1c93eedae15d9f548ab67038caa977858cf1",
        "partitions": [],
        "nonce": "3416788000155518426",
        "authority": "ZYz9bhvfPUbuQZoWEMPFuS5q5Cgkv91a6f",
        "signature": "3045022100a622beb975a8cf89330b8d474b377b92b3c57999fcd85d94f3b90375ae3da2a0022000b46b2764a35e12ec5181f5e7f92ff858bb8b954ab8fdbb41d577c4b9a2aedf"
    }
]
```

### Blocks by Slot / Hash
A specific block may be retrieved by its hash key or by its slot number.
* GET
``` 
http://54.91.216.164:12035/chain/api/network/blocks/{{id}}
```

* Response
```json
{
    "hash": "d68469b5e9177f652297858508a68c30cd664ca0288a8fb7daf09569a841a8b6",
    "slot": 50,
    "version": "0.0.0.1",
    "previousBlock": "5f5fc50035080598ea9c7cd9a32aa62f5f1344118df9f1e1cbdcadc0841b9e0d",
    "partitions": [],
    "nonce": "5790750755902305058",
    "authority": "ZYz9bhvfPUbuQZoWEMPFuS5q5Cgkv91a6f",
    "signature": "3046022100eafa7368f3130d7bb27c1357d641ebc95c3ad0d50d52538d6a64d260f75f56a6022100c8572f788ce07adc61723b33604ce0cd9a44b01d120ba2253ccb8ebefe21a6a2"
}
```

### Inject Entry
Add a transaction entry for your application to the blockchain. Note that
this entry must be a valid message according to the application configuration
that you set up.

Use always HEX encode.

* Request:
    - app: length of 4 alphanumeric. This is the application id. (Do not use "CHLG");
    - encoding: hex
    - value: The HEX encoded value that you want to add to the blockchain


* POST
``` 
http://54.91.216.164:12035/chain/api/network/entries
```
* Headers
    - Accept : application/json
    - Content-Type : application/json 

* Body
```json
{
	"app":"{{app}}",
	"encoding":"hex",
	"value":"{{encoded value}}"
}
```

* Response
```json
{
    "hash": "fa860ce1cf3f2145d446d98715fc5c91019ce5094dc3dcaf514b18e7b76cdc1e",
    "status": "pending"
}
```

### Entry status
Returns full detail of the value of the blockchain entry
referenced by the specified hashkey, if it has been previously recorded
by this node.

* GET
``` 
http://54.91.216.164:12035/chain/api/network/entries/{{id}}
```

* Response
```json
{
    "hash": "6ac28a43ea48221563c3c927ac64cdedb3ec86d6f7f5aa8417756800f1586219",
    "slot": 1726,
    "status": "confirmed",
    "value": "5465737420233361"
}
```

