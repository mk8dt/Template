package com.mk.template.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mk.template.data.UserSettings
import com.mk.template.navigation.Routes
import com.mk.template.navigation.TemplateNavHost
import com.mk.template.navigation.isMainRoute
import com.mk.template.ui.components.TemplateBottomNavigation
import com.mk.template.ui.components.TemplateTopBar
import com.mk.template.ui.theme.TemplateTheme
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { InitApp() }
    }
}

@Composable
fun InitApp() {

    val userSettings: UserSettings = koinInject()

    KoinContext {

        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentScreen = navBackStackEntry?.destination?.route
        val themeStream = userSettings.themeStream.collectAsState()

        TemplateTheme(appTheme = themeStream.value) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    topBar = {
                        if (currentScreen?.isMainRoute() == true)
                            TemplateTopBar(
                                navController = navController,
                                onClick = { navController.navigate(Routes.NOTIFICATIONS.nameRoute) }
                            )
                    },
                    bottomBar = { TemplateBottomNavigation(navController = navController) }
                ) { innerPadding ->
                    TemplateNavHost(navHostController = navController, paddingValues = innerPadding)
                }
            }
        }
    }
}


