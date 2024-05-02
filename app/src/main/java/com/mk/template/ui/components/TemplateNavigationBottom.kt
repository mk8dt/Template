package com.mk.template.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mk.template.navigation.ScreenBar
import com.mk.template.navigation.isMainRoute

@Composable
fun TemplateBottomNavigation(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination?.route
    val screenBarItems = ScreenBar.entries.toTypedArray()
    var selectedItem by rememberSaveable { mutableStateOf(screenBarItems.first()) }

    if (currentScreen?.isMainRoute() == true) {
        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.background
        ) {
            screenBarItems.forEach { item ->
                NavigationBarItem(
                    selected = selectedItem == item,
                    onClick = {
                        selectedItem = item
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    label = { Text(text = item.label) },
                    icon = { Icon(item.icon, item.label) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onTertiary,
                        selectedTextColor = MaterialTheme.colorScheme.onTertiary,
                        indicatorColor = MaterialTheme.colorScheme.background,
                        unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                        unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(0.7f)
                    )
                )
            }
        }
    }
}
