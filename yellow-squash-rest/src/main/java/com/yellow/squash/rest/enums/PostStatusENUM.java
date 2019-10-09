package com.yellow.squash.rest.enums;

public enum PostStatusENUM {

	Draft, // when not submitted for admin approval
	Pending, // when waiting for approval from admin
	Approved, // when admin approved but neither the author nor the admin has published
	Published // when the post is finally published
}
