json.extract! reservation, :id, :pick_up_date, :book_id, :member_id, :created_at, :updated_at
json.url reservation_url(reservation, format: :json)