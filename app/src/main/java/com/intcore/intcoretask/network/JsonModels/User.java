
package com.intcore.intcoretask.network.JsonModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User  implements Parcelable {

    @SerializedName("id")
    @Expose
    public long id;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("friends_count")
    @Expose
    private Integer friendsCount;
    @SerializedName("listed_count")
    @Expose
    private Integer listedCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("favourites_count")
    @Expose
    private Integer favouritesCount;
    @SerializedName("utc_offset")
    @Expose
    private Object utcOffset;
    @SerializedName("time_zone")
    @Expose
    private Object timeZone;
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("statuses_count")
    @Expose
    private Integer statusesCount;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @SerializedName("is_translation_enabled")
    @Expose
    private Boolean isTranslationEnabled;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    @Expose
    private Object profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private Object profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @SerializedName("profile_image_url")
    @Expose
    public String profileImageUrl;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @SerializedName("has_extended_profile")
    @Expose
    private Boolean hasExtendedProfile;
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @SerializedName("following")
    @Expose
    private Boolean following;
    @SerializedName("live_following")
    @Expose
    private Boolean liveFollowing;
    @SerializedName("follow_request_sent")
    @Expose
    private Boolean followRequestSent;
    @SerializedName("notifications")
    @Expose
    private Boolean notifications;
    @SerializedName("muting")
    @Expose
    private Boolean muting;
    @SerializedName("blocking")
    @Expose
    private Boolean blocking;
    @SerializedName("blocked_by")
    @Expose
    private Boolean blockedBy;
    @SerializedName("translator_type")
    @Expose
    private String translatorType;

    public User(Parcel in) {
        id = in.readLong();
        idStr = in.readString();
        name = in.readString();
        screenName = in.readString();
        location = in.readString();
        description = in.readString();
        byte tmp_protected = in.readByte();
        _protected = tmp_protected == 0 ? null : tmp_protected == 1;
        if (in.readByte() == 0) {
            followersCount = null;
        } else {
            followersCount = in.readInt();
        }
        if (in.readByte() == 0) {
            friendsCount = null;
        } else {
            friendsCount = in.readInt();
        }
        if (in.readByte() == 0) {
            listedCount = null;
        } else {
            listedCount = in.readInt();
        }
        createdAt = in.readString();
        if (in.readByte() == 0) {
            favouritesCount = null;
        } else {
            favouritesCount = in.readInt();
        }
        byte tmpGeoEnabled = in.readByte();
        geoEnabled = tmpGeoEnabled == 0 ? null : tmpGeoEnabled == 1;
        byte tmpVerified = in.readByte();
        verified = tmpVerified == 0 ? null : tmpVerified == 1;
        if (in.readByte() == 0) {
            statusesCount = null;
        } else {
            statusesCount = in.readInt();
        }
        lang = in.readString();
        byte tmpContributorsEnabled = in.readByte();
        contributorsEnabled = tmpContributorsEnabled == 0 ? null : tmpContributorsEnabled == 1;
        byte tmpIsTranslator = in.readByte();
        isTranslator = tmpIsTranslator == 0 ? null : tmpIsTranslator == 1;
        byte tmpIsTranslationEnabled = in.readByte();
        isTranslationEnabled = tmpIsTranslationEnabled == 0 ? null : tmpIsTranslationEnabled == 1;
        profileBackgroundColor = in.readString();
        byte tmpProfileBackgroundTile = in.readByte();
        profileBackgroundTile = tmpProfileBackgroundTile == 0 ? null : tmpProfileBackgroundTile == 1;
        profileImageUrl = in.readString();
        profileImageUrlHttps = in.readString();
        profileLinkColor = in.readString();
        profileSidebarBorderColor = in.readString();
        profileSidebarFillColor = in.readString();
        profileTextColor = in.readString();
        byte tmpProfileUseBackgroundImage = in.readByte();
        profileUseBackgroundImage = tmpProfileUseBackgroundImage == 0 ? null : tmpProfileUseBackgroundImage == 1;
        byte tmpHasExtendedProfile = in.readByte();
        hasExtendedProfile = tmpHasExtendedProfile == 0 ? null : tmpHasExtendedProfile == 1;
        byte tmpDefaultProfile = in.readByte();
        defaultProfile = tmpDefaultProfile == 0 ? null : tmpDefaultProfile == 1;
        byte tmpDefaultProfileImage = in.readByte();
        defaultProfileImage = tmpDefaultProfileImage == 0 ? null : tmpDefaultProfileImage == 1;
        byte tmpFollowing = in.readByte();
        following = tmpFollowing == 0 ? null : tmpFollowing == 1;
        byte tmpLiveFollowing = in.readByte();
        liveFollowing = tmpLiveFollowing == 0 ? null : tmpLiveFollowing == 1;
        byte tmpFollowRequestSent = in.readByte();
        followRequestSent = tmpFollowRequestSent == 0 ? null : tmpFollowRequestSent == 1;
        byte tmpNotifications = in.readByte();
        notifications = tmpNotifications == 0 ? null : tmpNotifications == 1;
        byte tmpMuting = in.readByte();
        muting = tmpMuting == 0 ? null : tmpMuting == 1;
        byte tmpBlocking = in.readByte();
        blocking = tmpBlocking == 0 ? null : tmpBlocking == 1;
        byte tmpBlockedBy = in.readByte();
        blockedBy = tmpBlockedBy == 0 ? null : tmpBlockedBy == 1;
        translatorType = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Object getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Object utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Object getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Object timeZone) {
        this.timeZone = timeZone;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public Boolean getIsTranslationEnabled() {
        return isTranslationEnabled;
    }

    public void setIsTranslationEnabled(Boolean isTranslationEnabled) {
        this.isTranslationEnabled = isTranslationEnabled;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public Object getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(Object profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public Object getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(Object profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Boolean getHasExtendedProfile() {
        return hasExtendedProfile;
    }

    public void setHasExtendedProfile(Boolean hasExtendedProfile) {
        this.hasExtendedProfile = hasExtendedProfile;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public Boolean getLiveFollowing() {
        return liveFollowing;
    }

    public void setLiveFollowing(Boolean liveFollowing) {
        this.liveFollowing = liveFollowing;
    }

    public Boolean getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public Boolean getMuting() {
        return muting;
    }

    public void setMuting(Boolean muting) {
        this.muting = muting;
    }

    public Boolean getBlocking() {
        return blocking;
    }

    public void setBlocking(Boolean blocking) {
        this.blocking = blocking;
    }

    public Boolean getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(Boolean blockedBy) {
        this.blockedBy = blockedBy;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public void setTranslatorType(String translatorType) {
        this.translatorType = translatorType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(idStr);
        dest.writeString(name);
        dest.writeString(screenName);
        dest.writeString(location);
        dest.writeString(description);
        dest.writeByte((byte) (_protected == null ? 0 : _protected ? 1 : 2));
        if (followersCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(followersCount);
        }
        if (friendsCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(friendsCount);
        }
        if (listedCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(listedCount);
        }
        dest.writeString(createdAt);
        if (favouritesCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(favouritesCount);
        }
        dest.writeByte((byte) (geoEnabled == null ? 0 : geoEnabled ? 1 : 2));
        dest.writeByte((byte) (verified == null ? 0 : verified ? 1 : 2));
        if (statusesCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(statusesCount);
        }
        dest.writeString(lang);
        dest.writeByte((byte) (contributorsEnabled == null ? 0 : contributorsEnabled ? 1 : 2));
        dest.writeByte((byte) (isTranslator == null ? 0 : isTranslator ? 1 : 2));
        dest.writeByte((byte) (isTranslationEnabled == null ? 0 : isTranslationEnabled ? 1 : 2));
        dest.writeString(profileBackgroundColor);
        dest.writeByte((byte) (profileBackgroundTile == null ? 0 : profileBackgroundTile ? 1 : 2));
        dest.writeString(profileImageUrl);
        dest.writeString(profileImageUrlHttps);
        dest.writeString(profileLinkColor);
        dest.writeString(profileSidebarBorderColor);
        dest.writeString(profileSidebarFillColor);
        dest.writeString(profileTextColor);
        dest.writeByte((byte) (profileUseBackgroundImage == null ? 0 : profileUseBackgroundImage ? 1 : 2));
        dest.writeByte((byte) (hasExtendedProfile == null ? 0 : hasExtendedProfile ? 1 : 2));
        dest.writeByte((byte) (defaultProfile == null ? 0 : defaultProfile ? 1 : 2));
        dest.writeByte((byte) (defaultProfileImage == null ? 0 : defaultProfileImage ? 1 : 2));
        dest.writeByte((byte) (following == null ? 0 : following ? 1 : 2));
        dest.writeByte((byte) (liveFollowing == null ? 0 : liveFollowing ? 1 : 2));
        dest.writeByte((byte) (followRequestSent == null ? 0 : followRequestSent ? 1 : 2));
        dest.writeByte((byte) (notifications == null ? 0 : notifications ? 1 : 2));
        dest.writeByte((byte) (muting == null ? 0 : muting ? 1 : 2));
        dest.writeByte((byte) (blocking == null ? 0 : blocking ? 1 : 2));
        dest.writeByte((byte) (blockedBy == null ? 0 : blockedBy ? 1 : 2));
        dest.writeString(translatorType);
    }
}
