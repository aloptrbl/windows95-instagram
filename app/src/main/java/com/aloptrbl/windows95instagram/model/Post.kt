package com.aloptrbl.windows95instagram.model

import com.aloptrbl.windows95instagram.R

data class Post(val name: String, val image: Int, val userImage: Int,
                val timePosted: String,
                val totalLikes: Int,
                val comments: List<Comment>,
                val caption: String)
data class Comment(
    val userName: String,
    val commentText: String
)

val comments1 = listOf(
    Comment("User1", "Great post!"),
    Comment("User2", "Thanks for sharing!")
)

val comments2 = listOf(
    Comment("User3", "Awesome!"),
    Comment("User4", "I love this!")
)

val itemsList = listOf(
    Post("Smith", R.drawable.kl, R.drawable.av1, "2 hours ago", 100, comments1, "wonder KL."),
    Post("Edward", R.drawable.mancity, R.drawable.av2, "1 day ago", 45, comments2, "Man city EPL winner season 23/24."),
            Post("Lisa", R.drawable.forest, R.drawable.av3, "4 day ago", 37, comments1, "nature is healing."),
Post("Gwen", R.drawable.nike, R.drawable.av4, "a week ago", 29, comments2, "Just do it!"),
    Post("Klara", R.drawable.sample1, R.drawable.av1, "1 minutes ago", 15, comments1, "Good Night."),
    Post("Simon", R.drawable.sample2, R.drawable.av2, "5 day ago", 18, comments2, "Bright day."),
    Post("Jason", R.drawable.sample3, R.drawable.av3, "2 day ago", 4, comments1, "aesthetic room."),
    Post("Rose", R.drawable.sample4, R.drawable.av4, "a week ago", 3, comments2, "Roaming around town."),
            Post("Simon", R.drawable.sample5, R.drawable.av2, "10 day ago", 20, comments2, "Movie time."),
Post("Jason", R.drawable.sample6, R.drawable.av3, "30 minutes ago", 120, comments1, "Game for life."),

    Post("Wendy", R.drawable.sample7, R.drawable.av5, "3 day ago", 37, comments1, ""),
    Post("Gwen", R.drawable.sample8, R.drawable.av2, "a months ago", 29, comments2, "kitty"),
    Post("Klara", R.drawable.sample9, R.drawable.av1, "4 minutes ago", 85, comments1, ""),
    Post("Simon", R.drawable.sample10, R.drawable.av5, "6 day ago", 18, comments2, ""),
    Post("Jason", R.drawable.sample11, R.drawable.av3, "1 day ago", 41, comments1, "be brave."),
    Post("Gwen", R.drawable.sample12, R.drawable.av4, "a week ago", 23, comments2, ":)"),
    Post("Klara", R.drawable.sample13, R.drawable.av3, "6 minutes ago", 80, comments1, "!"),

)
