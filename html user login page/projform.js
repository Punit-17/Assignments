function Validate(){
    
    // var a = nameCheck()
    var b = emailCheck()
    var c = mobileCheck()

  

    if(b && c)return true;
    else return false;
}

// function nameCheck(){
//     var fname = document.getElementById("username").value;
//     var exp = "^[A-Z]{1}[A-Za-z]{2,}$"
//     var err = false;

//     if(!fname.match(exp)){
//         err = true;
//         document.getElementById("fNameErr").innerHTML = "only alphabets allowed and First letter should be capital";
//     }
//     return !err

// }
function emailCheck(){
    var email = document.getElementById("email").value
    var exp = "^[A-Za-z0-9._%+-]+[@]{1}[A-Za-z0-9.-]+[.]{1}[A-Za-z]{2,4}$"

    if(!email.match(exp)){
        document.getElementById("emailErr").innerHTML = "Enter Valid Email ID"
        return false;
    }
    return true
}
function mobileCheck(){
    var mobile = document.getElementById("mobile").value
    var exp = "^[6-9]{1}[0-9]{9}$"

    if(!mobile.match(exp)){
        document.getElementById("mobileErr").innerHTML = "Entre Valid Mobile Number"
        return false
    }
    else
    return true
}