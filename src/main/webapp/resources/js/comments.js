$(document).ready(function() {
    var currentURL = window.location.pathname + window.location.search;
    var match = currentURL.match(/\/([^/]+)\/([^/]+)\/read\/(\d+)\?minorCategory=([^&]+)/);
    if (match) {
        var mainCategory = match[1];
        var subCategory = match[2];
        var posts_num = match[3];
        var minorCategory = match[4];

        loadCommentsList(mainCategory, subCategory, posts_num, minorCategory);
    }
    
    function loadCommentsList(mainCategory, subCategory, posts_num, minorCategory) {
        $.ajax({
            type: "GET",
            url: "/board/" + mainCategory + "/" + subCategory + "/read/" + posts_num + "?minorCategory=" + minorCategory,
            dataType: "json",
            success: function(data) {
                var commentsList = $("#commentsList");
                commentsList.empty();

                if (data.length === 0) {
                    commentsList.append("<li>댓글이 없습니다.</li>");
                } else {
                    data.forEach(function(comments) {
                        var listItem = $("<li>");
                        var member_nickname = $("<p>").text("작성자: " + comments.member_nickname).addClass("member_nickname");
                        var commentsContent = $("<p>").text(comments.comments_content).addClass("commentsContent");

                        var commentsFormatDate = new Date(comments.comments_date);

                        var options = { month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit' };
                        var formattedDate = commentsFormatDate.toLocaleString('ko-KR', options);

                        var commentsDate = $("<p>").text("작성일: " + formattedDate).addClass("commentsDate");
                        
                        var replyButton = $("<button>").text("댓글쓰기").addClass("comment-button");
                        var editButton = $("<button>").text("수정").addClass("comment-button");
                        var deleteButton = $("<button>").text("삭제").addClass("comment-button");

                        replyButton.on("click", function() {
                        });

                        editButton.on("click", function() {
                        });

                        deleteButton.on("click", function() {
                        });

                        listItem.append(member_nickname, commentsDate, commentsContent, replyButton, editButton, deleteButton);
                        commentsList.append(listItem);
                    });
                }
            },
            error: function(xhr, status, error) {
                console.error("오류 발생:", status, error);
                alert("댓글을 불러오는데 실패했습니다.");
            }
        });
    }
    
    $("#commentButton").click(function () {
        
        var member_nickname = $("#writer").val();
        var comments_content = $("#content").val();
        var posts_num = $("#postId").val();

        console.log("posts_num in click event: " + posts_num);
        
        var commentData = {
            "member_nickname": member_nickname,
            "comments_content": comments_content,
            "posts_num": posts_num,
        };
        
        $.ajax({
            type: "POST",
            url: "/board/commentsInsert", 
            data: JSON.stringify(commentData),
            contentType: "application/json; charset=utf-8",
            success: function (response) {
                console.log("댓글이 성공적으로 추가되었습니다.");
                loadCommentsList(mainCategory, subCategory, posts_num, minorCategory)
                $("#writer").val(""); 
                $("#content").val(""); 
            },
            error: function () {
                console.error("댓글 추가 중에 오류가 발생했습니다.");
            }
        });
    });
});
    