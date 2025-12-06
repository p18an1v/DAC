var express = require('express');
var app = express();
console.log(app);
app.get('/', function (req, res) {
   res.send('Hello World');
})

var server = app.listen(8081,"127.0.0.1" ,function () {
   var host = server.address().address
    
   var port = server.address().port
   console.log(server);
   console.log("Example app listening at http://%s :%s", host, port)
})