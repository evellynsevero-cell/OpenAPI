package com.zup.openAPI.models;

public class Task {
        private Long id;
        private String title;
        private boolean done;
        private String description;

        public Task() {}

        public Task(Long id, String title, boolean done, String description) {
            this.id = id;
            this.title = title;
            this.done = done;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }
