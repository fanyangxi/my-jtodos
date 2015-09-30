/*
 * factories, services
 */

'use strict';

var services = angular.module('myapp.services', ['ngResource']);

services.factory('UsersFactory', function($resource) {
    return $resource('/users', {}, {
        query: { method: 'GET', isArray: 'True' },
        create: { method: 'POST' }
    })
});

services.factory('UserFactory', function($resource) {
    return $resource('/users/:id', {}, {
        show: { method: 'GET', params: { id: '@id' } },
        update: { method: 'PUT', params: { id: '@id' } },
        delete: { method: 'DELETE', params: { id: '@id' } }
    })
});

services.factory('TodoitemsFactory', function($resource) {
    return $resource('/:userid/todoitems', {}, {
        query: { method: 'GET', isArray: 'True', params: { userid: '@userid' } },
        create: { method: 'POST', params: { userid: '@userid' } }
    })
});

services.factory('TodoitemFactory', function($resource) {
    return $resource('/:userid/todoitems/:id', {}, {
        show: { method: 'GET', isArray: 'True', params: { userid: '@userid', id: '@id' } },
        update: { method: 'POST', params: { userid: '@userid', id: '@id' } },
        delete: { method: 'DELETE', params: { userid: '@userid', id: '@id' } }
    })
});