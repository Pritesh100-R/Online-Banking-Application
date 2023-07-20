package com.example.Banking.Services.IMplementation;

import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.UpdateDetails;
import com.example.Banking.Models.viewtocustomer;
import com.example.Banking.Repositrories.viewrepo;
import com.example.Banking.actions.CustomerDetailsResponse;
import com.example.Banking.Repositrories.CustomerRepo;
import com.example.Banking.Services.CustomerDetailService;
import com.example.Banking.actions.UpdatepasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailImpl implements CustomerDetailService {
    @Autowired
    CustomerRepo createrepo;
    @Autowired
    viewrepo vrepo;


//    @Autowired
//    private CustomerDetailsResponse response;
    @Override
    public CustomerDetailsResponse CreateAcc(CustomerDetails customer) {
        CustomerDetailsResponse response = new CustomerDetailsResponse();
        Boolean flag=true;
        response.setTemp(flag);
        response.setMessage("Successfull Registration!");
        if (usernameexist(customer.getUsername())){
            flag = false;
            response.setMessage("Username already exist please try another one");
        }
        if (flag) {
            createrepo.save(customer);
        }
        return response;
    }
    public Boolean usernameexist(String username){
        CustomerDetails customer= createrepo.findbyusername(username);
        if (customer == null){
            return false;
        }
        return true;
//        if (createrepo.findbyusername(username) == 0){
//            return  false;
//        }
//        else{
//            return true;
//        }
//          Integer cust = createrepo.findbyusername(username);
//          if (cust != 0){
//              return true;
//          }
//          return false;
//        try{
//            CustomerDetails customer= createrepo.findbyusername(username);
//            //System.out.println(cust.toString());
//            return true;
//        }
//        catch(Exception e){
//            return false;
//        }


    }

    @Override
    public List<CustomerDetails> show() {
        return (List<CustomerDetails>) createrepo.findAll();
    }

    @Override
    public UpdatepasswordResponse updatepass(UpdateDetails pass) {
        boolean flag=true;
        UpdatepasswordResponse response=new UpdatepasswordResponse();
        String message="Update successful";
        CustomerDetails cust= createrepo.findbyusername(pass.getUsername());
        if (cust.getPassword().length()!=0 && pass.getNewpassword().length()!=0){
            createrepo.updatepass(pass.getNewpassword(), cust.getPassword());
//            if (cust.getPassword()==pass.getPassword()){
//                createrepo.updatepass(pass.getNewpassword(), cust.getPassword());
//            }
//            else{
//                flag=false;
//                message="Old password is wrong";
//            }
        }
        else{
            flag=false;
            message="Field is empty";
        }
        response.flag=flag;
        response.setMessage(message);
        return response;

    }


}
