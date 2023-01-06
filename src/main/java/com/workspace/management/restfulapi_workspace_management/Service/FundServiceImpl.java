package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Dao.FundDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundDao fundDao;

    @Override
    public ResponseEntity<List<Fund>> getFunds() {
        try
        {
            return new ResponseEntity<>(fundDao.findAll(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public HttpStatus addFund(Fund fund) {
        try
        {
            fundDao.save(fund);
            return HttpStatus.OK;
        }
        catch(Exception e)
        {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
