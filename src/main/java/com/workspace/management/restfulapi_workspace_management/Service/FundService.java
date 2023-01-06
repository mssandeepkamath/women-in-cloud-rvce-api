package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Fund;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FundService {

    public ResponseEntity<List<Fund>> getFunds();

    public HttpStatus addFund(Fund fund);


}
