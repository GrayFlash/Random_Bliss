const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const items = require('./routes/api/items');
const app = express();

// Bodyparser Middleware

app.use(bodyParser.json());

const db = 'mongodb+srv://ShoppingList:CwjkaX2Fbr3OI7Zd@cluster0-oi6g0.mongodb.net/Mern_Stack_Traverse?retryWrites=true&w=majority'

// Connect to Mongo
mongoose.connect(db,
    {
        useNewUrlParser: true,
        useUnifiedTopology: true
    })
.then(()=> console.log("MongoDB Connected.."))
.catch(err=>console.log(err))

// Use Routes
app.use('/api/items', items);

const port= process.env.PORT || 5000;

app.listen(port, ()=> 
console.log(`Server stared at port: ${port}`)
)