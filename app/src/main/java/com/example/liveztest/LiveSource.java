package com.example.liveztest;

import java.util.ArrayList;

public class LiveSource {
    private ArrayList<String> live_stream_uris;
    private int id;
    private String name;
    private String name2;
    private String description;
    private Logo  logo;
    private Logo  logo2;
    private Current_Program current_program;
    private Epg epg;


    public ArrayList<String> getLive_stream_uris() {
        return live_stream_uris;
    }
    public void setLive_stream_uris(ArrayList<String> live_stream_uris) {
        this.live_stream_uris = live_stream_uris;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Current_Program getCurrent_program() {
        return current_program;
    }

    public void setCurrent_program(Current_Program current_program) {
        this.current_program = current_program;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public Logo getLogo2() {
        return logo2;
    }

    public void setLogo2(Logo logo2) {
        this.logo2 = logo2;
    }

    public Epg getEpg() {
        return epg;
    }

    public void setEpg(Epg epg) {
        this.epg = epg;
    }

    class Logo {
        public int id;
        public String uri;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }

    class Current_Program {
        private int id;
        private String startsAt;
        private String endsAt;
        private String name;
        private Product product;
        private Banner banner;
        private String picture;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStartsAt() {
            return startsAt;
        }

        public void setStartsAt(String startsAt) {
            this.startsAt = startsAt;
        }

        public String getEndsAt() {
            return endsAt;
        }

        public void setEndsAt(String endsAt) {
            this.endsAt = endsAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public Banner getBanner() {
            return banner;
        }

        public void setBanner(Banner banner) {
            this.banner = banner;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        class Product {
            private int id;
            private String name;
            private String sku;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }
        }
        class Banner {
            private String width;
            private String height;
            private String uri;
            private int id;

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }



            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }



            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }


            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }
        }
    }
    class Epg {
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }

}
