class ShopController < ApplicationController
  def index
      @books = Book.order("title asc").all
  end
end
