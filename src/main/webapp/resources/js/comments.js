$(document).ready(function() {
    var currentURL = window.location.pathname;
    var match = currentURL.match(/\/board\/read\/(\d+)/);
    // 정규표현식 에서 글번호 추출하기
    
    if (match) {
        var posts_num = match[1];

        loadCommentsList(posts_num);
    }
    
    function loadCommentsList(posts_num) {
        $.ajax({
            type: "GET",
            url: "/board/read/" + posts_num,
            dataType: "json",
            success: function(data) {
                var commentsList = $("#commentsList");
                commentsList.empty();

                if (data.length === 0) {
                    commentsList.append("<li>댓글이 없습니다.</li>");
                } else {
                    data.forEach(function(comments) {
                        var listItem = $("<li>");
                        var commentsName = $("<p>").text("작성자: " + comments.comments_name).addClass("commentsName");
                        var commentsContent = $("<p>").text(comments.comments_content).addClass("commentsContent");

                        var commentsFormatDate = new Date(comments.comments_date);

                        var options = { month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit' };
                        var formattedDate = commentsFormatDate.toLocaleString('ko-KR', options);

                        var commentsDate = $("<p>").text("작성일: " + formattedDate).addClass("commentsDate");
                        
                        var replyButton = $("<button>").text("댓글쓰기").addClass("comment-button");
                        var editButton = $("<button>").text("수정").addClass("comment-button");
                        var deleteButton = $("<button>").text("삭제").addClass("comment-button");

                        replyButton.on("click", function() {
                            var replyForm = $("<div>").addClass("reply-form");
                            var nameInput = $("<input>").attr("type", "text").attr("placeholder", "이름");
                            var contentInput = $("<textarea>").attr("placeholder", "내용");
                            var saveButton = $("<button>").text("저장");
                            var cancelButton = $("<button>").text("취소");
                        });

                        editButton.on("click", function() {
                        });

                        deleteButton.on("click", function() {
                        });

                        listItem.append(commentsName, commentsDate, commentsContent, replyButton, editButton, deleteButton);
                        commentsList.append(listItem);
                    });
                }
            },
            error: function() {
                alert("댓글을 불러오는데 실패했습니다.");
            }
        });
    }
    
    $("#commentButton").click(function () {
        
        var comments_name = $("#writer").val();
        var comments_content = $("#content").val();
        var posts_num = $("#postId").val();
        
        var commentData = {
            "comments_name": comments_name,
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
                loadCommentsList(posts_num)
                $("#writer").val(""); 
                $("#content").val(""); 
            },
            error: function () {
                console.error("댓글 추가 중에 오류가 발생했습니다.");
            }
        });
    });
});
    