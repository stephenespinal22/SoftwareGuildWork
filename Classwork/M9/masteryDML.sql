use Blog;

SELECT DISTINCT BlogPosts.blogId, blogPreview, blogTitle, blogContent, isPublished, postDate, featuredImagePath, BlogPosts.userId, `username` FROM BlogPosts
INNER JOIN `user` as Users ON Users.`id` = BlogPosts.userId 
LEFT JOIN BlogPostsHashTags as bpht ON BlogPosts.blogId = bpht.blogId 
LEFT JOIN HashTags as ht ON ht.hashTagId = bpht.hashTagId 
LEFT JOIN BlogPostsCategory as bpc ON BlogPosts.blogId = bpc.blogId 
LEFT JOIN Category as cat ON cat.categoryId = bpc.categoryId WHERE cat.categoryName LIKE '%Bus%' 