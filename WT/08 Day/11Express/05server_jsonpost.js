const express = require('express');
const app = express();
const PORT = 3000; 
// Middleware to parse JSON
app.use(express.json());

app.post('/myjson', (req, res) => {
    console.log('Received JSON:', req.body);
    
    // Sending back the same JSON data
    res.json(req.body);
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});