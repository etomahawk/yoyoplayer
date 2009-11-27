/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function gc(obj) {
    for(var key in obj) {
        obj[key] = undefined;
    }
    obj = undefined;
}