package ru.syndicate.matule.ui.utils

import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

fun Navigator.safePush(screen: Screen) {
    if (this.lastItem.key != screen.key) this.push(screen)
}