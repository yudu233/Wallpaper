package com.rain.api.data;

import java.util.List;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ImageInfo
 * @CreateDate: 2020/7/4 10:47
 * @Describe:
 */
public class ImageInfo {

    /**
     * id : 1B22CkThfU0
     * created_at : 2020-08-24T12:52:02-04:00
     * updated_at : 2020-08-25T07:10:01-04:00
     * promoted_at : null
     * width : 4240
     * height : 2832
     * color : #FDFDFE
     * description : Big 4 Ice Caves
     * alt_description : white sand with water during daytime
     * urls : {"raw":"https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9","full":"https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjEyMDd9","regular":"https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9","small":"https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9","thumb":"https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9"}
     * links : {"self":"https://api.unsplash.com/photos/1B22CkThfU0","html":"https://unsplash.com/photos/1B22CkThfU0","download":"https://unsplash.com/photos/1B22CkThfU0/download","download_location":"https://api.unsplash.com/photos/1B22CkThfU0/download"}
     * categories : []
     * likes : 8
     * liked_by_user : false
     * current_user_collections : []
     * sponsorship : null
     * user : {"id":"dg4S8j5TzmE","updated_at":"2020-08-27T11:42:02-04:00","username":"karsten116","name":"Karsten Winegeart","first_name":"Karsten","last_name":"Winegeart","twitter_username":"karsten116","portfolio_url":null,"bio":null,"location":"Austin Texas","links":{"self":"https://api.unsplash.com/users/karsten116","html":"https://unsplash.com/@karsten116","photos":"https://api.unsplash.com/users/karsten116/photos","likes":"https://api.unsplash.com/users/karsten116/likes","portfolio":"https://api.unsplash.com/users/karsten116/portfolio","following":"https://api.unsplash.com/users/karsten116/following","followers":"https://api.unsplash.com/users/karsten116/followers"},"profile_image":{"small":"https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32","medium":"https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64","large":"https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128"},"instagram_username":"karsten116","total_collections":0,"total_likes":61,"total_photos":129,"accepted_tos":true}
     */

    private String id;
    private String created_at;
    private String updated_at;
    private int width;
    private int height;
    private String color;
    private String description;
    private String alt_description;
    private UrlsBean urls;
    private LinksBean links;
    private int likes;
    private boolean liked_by_user;
    private Object sponsorship;
    private UserBean user;
    private List<?> categories;
    private List<?> current_user_collections;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlt_description() {
        return alt_description;
    }

    public void setAlt_description(String alt_description) {
        this.alt_description = alt_description;
    }

    public UrlsBean getUrls() {
        return urls;
    }

    public void setUrls(UrlsBean urls) {
        this.urls = urls;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public Object getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Object sponsorship) {
        this.sponsorship = sponsorship;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<?> getCategories() {
        return categories;
    }

    public void setCategories(List<?> categories) {
        this.categories = categories;
    }

    public List<?> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<?> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public static class UrlsBean {
        /**
         * raw : https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9
         * full : https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjEyMDd9
         * regular : https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9
         * small : https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9
         * thumb : https://images.unsplash.com/photo-1598287635185-54c4b9c804b1?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9
         */

        private String raw;
        private String full;
        private String regular;
        private String small;
        private String thumb;

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }

    public static class LinksBean {
        /**
         * self : https://api.unsplash.com/photos/1B22CkThfU0
         * html : https://unsplash.com/photos/1B22CkThfU0
         * download : https://unsplash.com/photos/1B22CkThfU0/download
         * download_location : https://api.unsplash.com/photos/1B22CkThfU0/download
         */

        private String self;
        private String html;
        private String download;
        private String download_location;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownload_location() {
            return download_location;
        }

        public void setDownload_location(String download_location) {
            this.download_location = download_location;
        }
    }

    public static class UserBean {
        /**
         * id : dg4S8j5TzmE
         * updated_at : 2020-08-27T11:42:02-04:00
         * username : karsten116
         * name : Karsten Winegeart
         * first_name : Karsten
         * last_name : Winegeart
         * twitter_username : karsten116
         * portfolio_url : null
         * bio : null
         * location : Austin Texas
         * links : {"self":"https://api.unsplash.com/users/karsten116","html":"https://unsplash.com/@karsten116","photos":"https://api.unsplash.com/users/karsten116/photos","likes":"https://api.unsplash.com/users/karsten116/likes","portfolio":"https://api.unsplash.com/users/karsten116/portfolio","following":"https://api.unsplash.com/users/karsten116/following","followers":"https://api.unsplash.com/users/karsten116/followers"}
         * profile_image : {"small":"https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32","medium":"https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64","large":"https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128"}
         * instagram_username : karsten116
         * total_collections : 0
         * total_likes : 61
         * total_photos : 129
         * accepted_tos : true
         */

        private String id;
        private String updated_at;
        private String username;
        private String name;
        private String first_name;
        private String last_name;
        private String twitter_username;
        private Object portfolio_url;
        private Object bio;
        private String location;
        private LinksBeanX links;
        private ProfileImageBean profile_image;
        private String instagram_username;
        private int total_collections;
        private int total_likes;
        private int total_photos;
        private boolean accepted_tos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getTwitter_username() {
            return twitter_username;
        }

        public void setTwitter_username(String twitter_username) {
            this.twitter_username = twitter_username;
        }

        public Object getPortfolio_url() {
            return portfolio_url;
        }

        public void setPortfolio_url(Object portfolio_url) {
            this.portfolio_url = portfolio_url;
        }

        public Object getBio() {
            return bio;
        }

        public void setBio(Object bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public LinksBeanX getLinks() {
            return links;
        }

        public void setLinks(LinksBeanX links) {
            this.links = links;
        }

        public ProfileImageBean getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(ProfileImageBean profile_image) {
            this.profile_image = profile_image;
        }

        public String getInstagram_username() {
            return instagram_username;
        }

        public void setInstagram_username(String instagram_username) {
            this.instagram_username = instagram_username;
        }

        public int getTotal_collections() {
            return total_collections;
        }

        public void setTotal_collections(int total_collections) {
            this.total_collections = total_collections;
        }

        public int getTotal_likes() {
            return total_likes;
        }

        public void setTotal_likes(int total_likes) {
            this.total_likes = total_likes;
        }

        public int getTotal_photos() {
            return total_photos;
        }

        public void setTotal_photos(int total_photos) {
            this.total_photos = total_photos;
        }

        public boolean isAccepted_tos() {
            return accepted_tos;
        }

        public void setAccepted_tos(boolean accepted_tos) {
            this.accepted_tos = accepted_tos;
        }

        public static class LinksBeanX {
            /**
             * self : https://api.unsplash.com/users/karsten116
             * html : https://unsplash.com/@karsten116
             * photos : https://api.unsplash.com/users/karsten116/photos
             * likes : https://api.unsplash.com/users/karsten116/likes
             * portfolio : https://api.unsplash.com/users/karsten116/portfolio
             * following : https://api.unsplash.com/users/karsten116/following
             * followers : https://api.unsplash.com/users/karsten116/followers
             */

            private String self;
            private String html;
            private String photos;
            private String likes;
            private String portfolio;
            private String following;
            private String followers;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getPhotos() {
                return photos;
            }

            public void setPhotos(String photos) {
                this.photos = photos;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getPortfolio() {
                return portfolio;
            }

            public void setPortfolio(String portfolio) {
                this.portfolio = portfolio;
            }

            public String getFollowing() {
                return following;
            }

            public void setFollowing(String following) {
                this.following = following;
            }

            public String getFollowers() {
                return followers;
            }

            public void setFollowers(String followers) {
                this.followers = followers;
            }
        }

        public static class ProfileImageBean {
            /**
             * small : https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32
             * medium : https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64
             * large : https://images.unsplash.com/profile-1583427783052-3da8ceab5579image?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128
             */

            private String small;
            private String medium;
            private String large;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }
    }
}
