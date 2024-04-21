//form validation
const valid = () => {
    var isValid =true;
    var form =document.forms['Application'];
    const accountNumber = form.accountNumber.value;
    const accountHolder = form.accountHolder.value;
    const dateOfApply=form.dateOfApply.value;
    const address=form.address.value;
    const signature=form.signature.files;
    const contactNumber=form.contactNumber.value;
    const email=form.email.value;
    var nameErr=document.getElementById("nameErr");
    var numberErr=document.getElementById("numberErr");
    var dateErr=document.getElementById("dateErr");
    var addressErr=document.getElementById("addressErr");
    var signatureErr=document.getElementById("signatureErr");
    var contactErr=document.getElementById("contactErr");
    var emailErr=document.getElementById("emailErr");
    try{
        if(!dateOfApply){
            //date validation
            throw "Date of apply can't be empty!!";
        }
    }catch(message){
        isValid=false;
        dateErr.innerHTML=message;
    }
    try {   //address validation
        if (!address.trim()) {
            throw "Address is required";
        }
    } catch (message) {
        isValid = false;
        addressErr.innerHTML = message;
    }
    try{
        if(!(/^\d{12}$/).test(accountNumber)){ //number validate
            throw "Account number should be exactly 12 digits";
        }
    }catch(message){
        isValid=false;
        numberErr.innerHTML=message;
    }

   
    try{
        if(!accountHolder.trim()){
            throw "Account Holder name is required";
        }
    }catch(message){
        isValid=false;
        nameErr.innerHTML = message;
    }
    try{
        
    // number validation>> 10 digits
        if(!(/^\d{10}$/).test(contactNumber)){
            throw "Contact Number should be exactly 10 digits!!";
        }
    }catch(message){
        isValid=false;
        contactErr.innerHTML=message;
    }

    try{
        
    //signature validation
        if (!signature || signature.length === 0) {
           throw "Signature file is required";
        }
    }catch(message){
        isValid=false;
        signatureErr.innerHTML=message;
    }

   
    try{
         //email validation
        if(!(/^\S+@\S+\.\S+$/.test(email))){
            throw "Invalid email format";
        }
    }catch (message) {
        isValid = false;
        emailErr.innerHTML = message;
    }
    return isValid;
}