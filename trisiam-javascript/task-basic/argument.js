let project = function () {
    const text = []
    for(const i of Object.keys(arguments)) {
        text.push(arguments[i]);
    }
  console.log(text.join());   
}

project();
project(1, "2");
project(true)