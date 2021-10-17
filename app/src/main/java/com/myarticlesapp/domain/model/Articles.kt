package com.myarticlesapp.domain.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Articles(
    var custom_feature_image_url: String,
    var post_title: String,
    var post_content: String,
    var post_date: String
)