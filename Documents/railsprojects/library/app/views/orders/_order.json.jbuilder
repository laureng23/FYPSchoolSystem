json.extract! order, :id, :member_id, :payment, :total, :created_at, :updated_at
json.url order_url(order, format: :json)