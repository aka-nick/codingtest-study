-- 코드를 입력하세요
-- 가장 리뷰를 많이 적은 회원의, 회원정보와, 리뷰정보

-- 가장 많이 적힌 리뷰 수와, 동일한 리뷰 수를 가진 회원의, 회원정보와, 리뷰정보
SELECT m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d')
FROM
    member_profile m
    JOIN
        (SELECT member_id
        FROM
        (SELECT
            member_id,
            count(member_id) as cnt
        FROM
            rest_review
        GROUP BY
            member_id) as cnts
        JOIN
        (SELECT
                count(member_id) as cnt
            FROM 
                rest_review
            GROUP BY
                member_id
            ORDER BY
                cnt DESC
            LIMIT 1 OFFSET 0) as maxcnt
        WHERE
            cnts.cnt = maxcnt.cnt) as maxmember
    ON 
        maxmember.member_id = m.member_id
    JOIN
        rest_review r
    ON
        m.member_id = r.member_id
ORDER BY
    r.review_date,
    r.review_text

# SELECT
#     m.member_name,
#     r.review_text,
#     r.review_date

# FROM
#     member_profile m
#     JOIN (
#         SELECT
#             count(member_id) as cnt
#         FROM 
#             rest_review
#         GROUP BY
#             member_id
#         ORDER BY
#             cnt DESC
#         LIMIT 1 OFFSET 0
#         ) maxcnt
#     ON m.member_id = sub.member_id
#     JOIN (
#         SELECT
#             review_id,
#             member_id
#         FROM
#             rest_review
#         WHERE 
            
#         ) maxreview
#     JOIN rest_review r
#     ON m.member_id = r.member_id

# ORDER BY
#     review_date,
#     review_text   
    
    
    
# SELECT
#     m.member_name,
#     r.review_text,
#     r.review_date

# FROM
#     member_profile m
#     JOIN (SELECT
#             member_id,
#             count(member_id) as cnt
#         FROM 
#             rest_review
#         GROUP BY
#             member_id
#         ORDER BY 
#             cnt DESC
#         LIMIT 1 OFFSET 0) sub
#     ON m.member_id = sub.member_id
#     JOIN rest_review r
#     ON m.member_id = r.member_id

# ORDER BY
#     review_date,
#     review_text   