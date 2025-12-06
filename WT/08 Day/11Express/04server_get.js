var express = require('express');
var app = express();

app.use(express.static('public'));
app.get('/getform', function (req, res) {
   res.sendFile( __dirname + "/" + "04get_form.html" );
})

app.get('/process_get', function (req, res) {
   // Prepare output in JSON format
   console.log(req.query);
   /*response = {
      first_name:req.query.first_name,
      last_name:req.query.last_name
   };*/
   let {first_name, last_name} = req.query;   
   console.log(first_name, last_name);
   res.end(JSON.stringify(response));
})

var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port
   
   console.log("Example app listening at http://%s:%s", host, port)
})