package com.example.shoesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoesapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/*
Add the following to allow Navigation:
- In the Application gradle:
    classpath "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0"
- In the Module gradle, u must add 'def nav_version = "2.3.3"' and then:
    implementation "android.arch.navigation:navigation-fragment-ktx:$nav_version"
    implementation "android.arch.navigation:navigation-ui-ktx:$nav_version"
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
For Data Binding, add in the Module Gradle:
    buildFeatures {
        dataBinding true
    }

Careful with the Navigation scheme and the way u use "popUpTo". Let's say that your app has three destinations—A, B,
and C—along with actions that lead from A to B, B to C, and C back to A.
With each navigation action, a destination is added to the back stack. If you were to navigate repeatedly through this
flow, your back stack would then contain multiple sets of each destination (A, B, C, A, B, C, A, and so on). To avoid
this repetition, you can specify app:popUpTo and app:popUpToInclusive in the action that takes you from destination C to
destination A. After reaching destination C, the back stack contains one instance of each destination (A, B, C). When
navigating back to destination A, we also popUpTo A, which means that we remove B and C from the stack while navigating.
With app:popUpToInclusive="true", we also pop that first A off of the stack, effectively clearing it. Notice here that
if you don't use app:popUpToInclusive, your back stack would contain two instances of destination A.

Take a look at Cards and colors CodeLab (5.2) for a reference to Glide and Styles and Themes. If u want to use
MaterialDesign for certain Views (Button in this case), follow the Youtube video
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //simple menu
//        return NavigationUI.onNavDestinationSelected(item, findNavController(R.id.myNavHostFragment)) || super.onOptionsItemSelected(item)

        //put the following code instead of the first line if u want to modify the behaviour of the menu item in the
        //login fragment
        if (item.itemId == R.id.loginScreen) {
            NavigationUI.onNavDestinationSelected(item, findNavController(R.id.myNavHostFragment))
            //make sure you return false when the menu item action would be implemented in onOptionsItemSelected(MenuItem item)
            //Fragment's method.
            return false
        }
        return super.onOptionsItemSelected(item)
    }


}