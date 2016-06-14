var http = require('http');
var fs = require('fs');
var arr = [];

var Fetcher = function(argv) {
  
	this.argv = argv;
	this.data = "";







	this.fetchMath = function() {

    var temp;    
    http.get('http://numbersapi.com/' +this.argv.math+'/math?json',function(res) {

       res.on("error",function(err){

         console.log("error in fetching data is" + err);

       });

      res.on("data", function(body) {
           
        temp=JSON.parse(body)
        console.log("Math : " + temp.text );
        if(argv.save){

         
         temp.Saved=new Date();
          arr.push(temp);
          Fetcher.prototype.saveFile("./facts.json");
        }
        
       });

     });
}


  this.fetchTrivia = function() {

    var temp;    
    http.get('http://numbersapi.com/' +this.argv.trivia+'/trivia?json',function(res) {

       res.on("error",function(err){

         console.log("error in fetching data is" + err);

       });

      res.on("data", function(body) {
           
        temp=JSON.parse(body)
        console.log("Trivia : " + temp.text );
        if(argv.save){

         
         temp.Saved=new Date();
          arr.push(temp);
          Fetcher.prototype.saveFile("./facts.json");
        }
        
       });

     });
}











	this.fetchDate = function() {

    var response;  

    var file = this.argv.date; 

if(file.length == 5){

var temp;
    http.get('http://numbersapi.com/' +file+'/date?json', function(res) {

       res.on("error",function(err){

         console.log("error in fetching data is" + err);

       });

      res.on("data", function(body) {
           
                temp=JSON.parse(body)

        console.log("Date : " +  JSON.parse(body).text);
        if(argv.save){
           temp.Saved=new Date();
          arr.push(temp);
          Fetcher.prototype.saveFile("./facts.json");
        }
        
       });

     });
  }

  else {
var temp;

    http.get('http://numbersapi.com/' +file+'/year?json', function(res) {

       res.on("error",function(err){

         console.log("error in fetching data is" + err);

       });

      res.on("data", function(body) {
                           temp=JSON.parse(body)

        
        console.log("Year : " +  JSON.parse(body).text);
        if(argv.save){
          temp.Saved=new Date();
          arr.push(temp);
          Fetcher.prototype.saveFile("./facts.json");
        }
        
       });

     });


  }



 }






 Fetcher.prototype.saveFile = function(filePath) {

 	var me = this;
 	fs.exists(filePath,function(ans) {

 		if(ans) {
 			fs.appendFile(filePath,JSON.stringify(arr,null,4),"utf8",function(err){

 				console.log("file Appended");
 			})

 		} else {


 			fs.writeFile(filePath,JSON.stringify(arr,null,4),"utf8",function(err){

 				console.log("file Created ");

 			});
 		}

 	});
 }

}

module.exports.numberAPI = Fetcher;