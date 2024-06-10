package com.brownx.a2d0.groups.presenter.friends

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.brownx.a2d0.groups.presenter.groups.components.AddGroupButton
import com.brownx.a2d0.ui.theme.softGrey

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun FriendsScreen(

) {
    val friendsViewModel = hiltViewModel<FriendsViewModel>()
    val friendsState by friendsViewModel.friendsState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(softGrey)
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            items(friendsState.friendsList) { friend ->

            }

            item {
                AddGroupButton {

                }
            }
        }
    }

}