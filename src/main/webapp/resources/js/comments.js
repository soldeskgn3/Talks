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
                    
                        listItem.append(commentsName, commentsDate, commentsContent);
                        commentsList.append(listItem);
                    });
                }
            },
            error: function() {
                alert("댓글을 불러오는데 실패했습니다.");
            }
        });
    }
});

$("#commentButton").click(function() {

    // 폼 데이터 수집
    var writer = $("#writer").val();
    var content = $("#content").val();
    var postId = $("#postId").val();

    // // 현재 시간을 가져와 포맷 변경
    // var currentDate = new Date();
    // var options = { month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit' };
    // var formattedDate = currentDate.toLocaleString('ko-KR', options);

    // JSON 데이터 생성
    var commentData = {
        "comments_name": writer,
        "comments_content": content,
        "posts_num": postId,
        // "datcomments_date": formattedDate
    };

    // JSON 데이터를 서버로 보냄 (예: AJAX 요청)
    $.ajax({
        type: "POST",
        url: "/board/commentsInsert", // 댓글을 추가하는 서버 엔드포인트 URL
        data: JSON.stringify(commentData),
        contentType: "application/json; charset=utf-8",
        success: function(response) {
            // 서버 응답 처리 (성공 시)
            console.log("댓글이 성공적으로 추가되었습니다.");
            // 원하는 작업 수행
        },
        error: function() {
            // 서버 응답 처리 (에러 발생 시)
            console.error("댓글 추가 중에 오류가 발생했습니다.");
            // 원하는 오류 처리 수행
        }
    });
});