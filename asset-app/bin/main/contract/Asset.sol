pragma solidity >=0.4.22<0.7;  
  
  
contract supplyChain {  
    struct Receipt {  
        address c;  
        address to;  
        uint amount;  
        uint status;  
    }  
    struct Company {  
        string company;  
        string adr;  
        uint t;  
    }  
    mapping(address => Company) public adr2Com;  
    mapping(address => uint) public balances;  
    Receipt[] rec;  
    address public bank;  
    constructor(){bank=msg.sender;}  
    function addCompany(string company_,string adr_,uint t_){  
        Company memory tem = Company(company_,adr_,t_);  
        adr2Com[msg.sender] = tem;  
    }  
    function accountsReceivable2Chain(address to_,uint amount_){  
        Receipt memory r = Receipt(msg.sender,to_,amount_,1);  
        rec.push(r);  
    }  
    function transferOfAccountsReceivable2Chain(address to_,uint amount_){  
        for(uint i=0;i<rec.length;++i){  
            if(rec[i].to == msg.sender&& rec[i].status == 1){  
                rec[i].amount-=amount_;  
                Receipt memory r = Receipt(rec[i].c,to_,amount_,1);  
                rec.push(r);  
                return;  
            }  
        }  
    }  
    function financing2Chain(uint amount_){  
        uint sum = 0;  
        for(uint i=0;i<rec.length;++i){  
            if(rec[i].to == msg.sender&& rec[i].status == 1){  
                sum+=rec[i].amount;  
            }  
        }  
        if(amount_<=sum) {  
            balances[msg.sender]+=amount_;  
            rec.push(Receipt(msg.sender,bank,amount_,0));  
        }  
        else {  
            balances[msg.sender]+=sum;  
            rec.push(Receipt(msg.sender,bank,sum,0));  
        }  
    }  
    function paymentSettlement2Chain(){  
        for(uint i=0;i<rec.length;++i){  
            if(rec[i].c==msg.sender){  
                balances[msg.sender]-=rec[i].amount;  
                balances[rec[i].to]+=rec[i].amount;  
                removeAtIndex(i);  
        i--;  
            }  
        }  
    }  
    function removeAtIndex(uint index)  {  
    if (index >= rec.length) return;  
    for (uint i = index; i < rec.length-1; i++) {  
      rec[i] = rec[i+1];  
    }  
    delete rec[rec.length-1];  
    rec.length--;  
  }  
}  pragma solidity >=0.4.22<0.7;  
  
  
contract supplyChain {  
    struct Receipt {  
        address c;  
        address to;  
        uint amount;  
        uint status;  
    }  
    struct Company {  
        string company;  
        string adr;  
        uint t;  
    }  
    mapping(address => Company) public adr2Com;  
    mapping(address => uint) public balances;  
    Receipt[] rec;  
    address public bank;  
    constructor(){bank=msg.sender;}  
    function addCompany(string company_,string adr_,uint t_){  
        Company memory tem = Company(company_,adr_,t_);  
        adr2Com[msg.sender] = tem;  
    }  
    function accountsReceivable2Chain(address to_,uint amount_){  
        Receipt memory r = Receipt(msg.sender,to_,amount_,1);  
        rec.push(r);  
    }  
    function transferOfAccountsReceivable2Chain(address to_,uint amount_){  
        for(uint i=0;i<rec.length;++i){  
            if(rec[i].to == msg.sender&& rec[i].status == 1){  
                rec[i].amount-=amount_;  
                Receipt memory r = Receipt(rec[i].c,to_,amount_,1);  
                rec.push(r);  
                return;  
            }  
        }  
    }  
    function financing2Chain(uint amount_){  
        uint sum = 0;  
        for(uint i=0;i<rec.length;++i){  
            if(rec[i].to == msg.sender&& rec[i].status == 1){  
                sum+=rec[i].amount;  
            }  
        }  
        if(amount_<=sum) {  
            balances[msg.sender]+=amount_;  
            rec.push(Receipt(msg.sender,bank,amount_,0));  
        }  
        else {  
            balances[msg.sender]+=sum;  
            rec.push(Receipt(msg.sender,bank,sum,0));  
        }  
    }  
    function paymentSettlement2Chain(){  
        for(uint i=0;i<rec.length;++i){  
            if(rec[i].c==msg.sender){  
                balances[msg.sender]-=rec[i].amount;  
                balances[rec[i].to]+=rec[i].amount;  
                removeAtIndex(i);  
        i--;  
            }  
        }  
    }  
    function removeAtIndex(uint index)  {  
    if (index >= rec.length) return;  
    for (uint i = index; i < rec.length-1; i++) {  
      rec[i] = rec[i+1];  
    }  
    delete rec[rec.length-1];  
    rec.length--;  
  }  
}  
