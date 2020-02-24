function calculate (x,y) {
    let kali = function(z) {
    
    console.log(x*z); 
    }
    if (y == null) {
    return kali;
    }
    console.log(x*y);
}

calculate(3,1);
calculate(3)(2);

//output 3
//output 6

