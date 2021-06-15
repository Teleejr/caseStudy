//Save registration information to local storage
let registration = [];
const newRegistration = (reg)=>{
    reg.preventDefault();// stop form from submitting
    let firstName = document.getElementById('fName').value;
    console.log(firstName);
    let lastName = document.getElementById('lName').value;
    console.log(lastName);
    let userName = document.getElementById('userName').value;
    console.log(tableName);
    let location = document.getElementById('city').value;
    console.log(location);
    let zip = document.getElementById('zip').value;
    console.log(zip);

    //regex so that only letters can be used to answer upper or lower case
    let re1 = new RegExp(/^[a-zA-Z][a-zA-Z\s]*$/);
    //Regex for zipcode
    let re2 = new RegExp(/^[0-9][0-9\s]*$/);


    //if nothing was typed
    if(firstName == "" || lastName == "" || userName == "" || location == "" || zip == ""){
        let message = "Entry must be valid. Fields cannot be empty.";
        alert(message);

    }
    // if what was typed does not match regex
    else if(!re.test(answer)){
        let message = "No numbers for Names, Username, or Location. Use only numbers for Zip." + answer + "Is not a valid entry";
        alert(message);

    }
    // if what was typed does match regex
    else{
    let input = {
        id: userName,
        firstName: document.getElementById('fName').value,
        lastName: document.getElementById('lName').value,
        userName: document.getElementById('userName').value,
        location: document.getElementById('city').value,
        zip: document.getElementById('zip').value
    }
    registration.push(input); // add to array
    document.querySelector('form').reset(); // clear the form
    // save to local storage
    localStorage.setItem('DOMContentLoaded', JSON.stringify(registration));
    alert('Your registration for ' + userName + ' has been confirmed!');
}
}
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('submit').addEventListener('click', newRegistration);
});
