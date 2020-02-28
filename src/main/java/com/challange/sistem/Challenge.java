package com.challange.sistem;


import io.swagger.annotations.Api;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.BlockApi;
import org.openapitools.client.api.TransactionEntryApi;
import org.openapitools.client.model.Block;
import org.openapitools.client.model.EntryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Challenge  {
    final ApiClient client;

    public void findPIN() {
        //Get the last block
//        List<Block> blocks = new BlockApi(client).blocksGet(null, null);

        //Get a list of blocks
//        List<Block> blocks = new BlockApi(client).blocksGet(offset, count);

        //Get an specific Entry
//        EntryInfo entryInfo = new TransactionEntryApi(client).entriesHashGet(hash);
    }

    public Challenge() {
        this.client = new ApiClient();
        client.setBasePath("http://localhost:12035/chain/api/network/");
    }
}
