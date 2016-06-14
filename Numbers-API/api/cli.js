var argv = require('yargs')
var module = require('./app.js')

var argvs = argv.usage('Rupal Jaiswal')
  .options('m', {
    alias: 'math',
    describe: 'Display math fact'
  })
  .options('t', {
    alias: 'trivia',
    describe: 'Display trivia fact',
  })
  .options('d', {
    alias: 'date',
    describe: 'Display date fact'
  })
  .options('y', {
    alias: 'year	',
    describe: 'Display year fact'
  })
  .argv;



  if (argvs.help) {
  argv.showHelp();
}

else if(argvs.math) {

var numberAPI = new module.numberAPI(argvs);
numberAPI.fetchMath();

} 

else  if(argvs.trivia){
var numberAPI = new module.numberAPI(argvs);
numberAPI.fetchTrivia();


}

else  if(argvs.date){
var numberAPI = new module.numberAPI(argvs);
numberAPI.fetchDate();
}