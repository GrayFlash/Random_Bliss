function test(){
    var wordsCount = 200;
    var x = words_generator(wordsCount);
    
    let element = document.getElementById("TextArea")
    console.log(x);
    console.log(element.innerText);
    element.innerText = x;
}
test();
function words_generator(wordsCount){
    var x = "";
    for( var i=0; i<wordsCount; i++){
        var alphabetsCount = Math.round(Math.random() * 10);
        var characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for(var j=0; j<alphabetsCount; j++){
            x += characters.charAt(Math.floor(Math.random() * characters.length));
        }
        x += " ";
    }
    return x;
}