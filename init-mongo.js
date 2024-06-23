// init-mongo.js

// Database to be initialized
var database = 'testdb';

// User to be created
var user = {
    user: 'testuser',
    pwd: 'testpassword',
    roles: [
        { role: 'readWrite', db: database },
        { role: 'dbAdmin', db: database },
    ],
};

// Create user
db.createUser({
    user: user.user,
    pwd: user.pwd,
    roles: user.roles,
});
