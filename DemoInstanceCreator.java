/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment1;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

/**
 *
 * @author xxb
 */
class DemoInstanceCreator implements InstanceCreator <Demographics>
{       @Override
        public Demographics createInstance(Type type) 
        {
            return new Demographics();
        }

     
}