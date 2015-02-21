var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var routes = require('./routes/index');
var users = require('./routes/users');

var app = express();
var rallies = 0;
var running = false;

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

// uncomment after placing your favicon in /public
//app.use(favicon(__dirname + '/public/favicon.ico'));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', routes);

app.post('/rally', function (req, res) {
  console.log("post to RALLY");  
    rallies++;
    res.send("{'rally': " + rallies + "}");
    res.end();
});

app.get('/rally', function (req, res) {
    console.log("get available rallies");  
    res.send("{'rally': " + rallies + "}");
    res.end();
    if (rallies > 0) {
        rallies--;
    }   
});

app.post('/startrun', function (req, res) {
    console.log("post to STARTRUN");  
    running = true;
    res.send("{'running': " + running + "}");
    res.end();
});

app.get('/running', function (req, res) {
    console.log("get running status");  
    res.send("{'running': " + running + "}");
    res.end();
});

// catch 404 and forward to error handler
app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
    app.use(function(err, req, res, next) {
        res.status(err.status || 500);
        res.render('error', {
            message: err.message,
            error: err
        });
    });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
        message: err.message,
        error: {}
    });
});


module.exports = app;
