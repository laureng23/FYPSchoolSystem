json.extract! review, :id, :rating, :descritpion, :recommend, :member_id, :book_id, :created_at, :updated_at
json.url review_url(review, format: :json)